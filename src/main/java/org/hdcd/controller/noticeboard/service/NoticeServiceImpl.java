package org.hdcd.controller.noticeboard.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.hdcd.ServiceResult;
import org.hdcd.mapper.INoticeMapper;
import org.hdcd.vo.NoticeFileVO;
import org.hdcd.vo.NoticeVO;
import org.hdcd.vo.PaginationInfoVO;
import org.springframework.stereotype.Service;

@Service
public class NoticeServiceImpl implements INoticeService {

	@Inject
	private INoticeMapper noticeMapper;
	
	@Override
	public ServiceResult insertNotice(HttpServletRequest req, NoticeVO noticeVO) {
		ServiceResult result = null;	// ServiceResult는 enum으로 만들어 둠.
		int cnt = noticeMapper.insertNotice(noticeVO); // 제목과 내용은 먼저 등록하고
		if(cnt > 0) {
			result = ServiceResult.OK;
			// 파일도 같이 넘겨줘야하죠! 
			List<NoticeFileVO> noticeFileList = noticeVO.getNoticeFileList();
			try {
				processNoticeList(noticeFileList, noticeVO.getBoNo(), req); // 이 안에서 파일업로드를 처리
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			result = ServiceResult.FAILED;
		}
		return result;
	}


	@Override
	public int selectNoticeCount(PaginationInfoVO<NoticeVO> pagingVO) {
		return noticeMapper.selectNoticeCount(pagingVO);
	}

	@Override
	public List<NoticeVO> selectNoticeList(PaginationInfoVO<NoticeVO> pagingVO) {
		return noticeMapper.selectNoticeList(pagingVO);
	}

	@Override
	public NoticeVO selectNotice(int boNo) {
		noticeMapper.incrementHit(boNo);		// 조회수 증가
		return noticeMapper.selectNotice(boNo);	// 게시글 1행 정보 조회	
	}

	@Override
	public ServiceResult updateNotice(HttpServletRequest req, NoticeVO noticeVO) {
		ServiceResult result = null;
		int cnt = noticeMapper.updateNotice(noticeVO);
		if(cnt > 0) {
			List<NoticeFileVO> noticeFileList = noticeVO.getNoticeFileList();
			try {
				processNoticeList(noticeFileList, noticeVO.getBoNo(), req);
				Integer[] delNoticeNo = noticeVO.getDelNoticeNo();
				if (delNoticeNo != null) {
					for (int i = 0; i < delNoticeNo.length; i++) {
						NoticeFileVO noticeFileVO = noticeMapper.selectNoticeFile(delNoticeNo[i]);
						noticeMapper.deleteNoticeFile(delNoticeNo[i]);
						File file = new File(noticeFileVO.getFileSavepath()); //getRealPath 워닝걸거나 더이상 사용불가라는 의미 req.getRealPath("/resources/upload") + 
						file.delete();
					}
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			result = ServiceResult.OK;
		}else {
			result = ServiceResult.FAILED;
		}
		return result;
	}

	@Override
	public ServiceResult deleteNotice(HttpServletRequest req, int boNo) {
		ServiceResult result = null;
		
		// 이제 파일로 날려줘야하니 아래 처리!
		NoticeVO noticeVO = noticeMapper.selectNotice(boNo);
		noticeMapper.deleteNoticeFileByBoNo(boNo);
		int cnt = noticeMapper.deleteNotice(boNo); // 원래는 삭제할때 이거만 날렸음! 근데 파일도 해야하서! 위아래 추가 많이 됨
		if(cnt > 0) {
			// 그 파일을 삭제하기 위해! 해당 진짜 파일들 얻어옴!
			List<NoticeFileVO> noticeList = noticeVO.getNoticeFileList();
			try {
				if(noticeList != null) { // 파일이 있는 상태겠지
					String[] filePath = noticeList.get(0).getFileSavepath().split("/"); // 파일이 갯수가 3개라하면 그 경로는 서버경로까지 동일하고 0번째 꺼내서 / 로 나눠 담고
					int cutNum = noticeList.get(0).getFileSavepath().lastIndexOf(filePath[filePath.length - 1]);	// 값을 확인해파일패스의 마지막부분하면 이름이 나오지
					String path = noticeList.get(0).getFileSavepath().substring(0, cutNum); // 그걸 잘라와서 substring이용해서 필요한거 또 자름!
					deleteFolder(req, path);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			result = ServiceResult.OK;
		}else {
			result = ServiceResult.FAILED;
		}
		
		return result;
	}


	private void processNoticeList(List<NoticeFileVO> noticeFileList, int boNo, HttpServletRequest req) throws IOException {
		// 파일 인지 데이터 있는지 확인하고
		if(noticeFileList != null && noticeFileList.size() > 0) {
			// 내가 넣은 데이터들 수 만큼 업로드하고! 데이터 넣고!
			for (NoticeFileVO noticeFileVO : noticeFileList) {
				String saveName = UUID.randomUUID().toString();
				String endFilename = noticeFileVO.getFileName().split("\\.")[1]; // 확장자 분리하고
				String saveLocate = req.getServletContext().getRealPath("/resources/upload"); //  이 서버경로 업로드를 하기위한
				File file = new File(saveLocate);
				// 혹시 폴더 없으면 만들고 아님 지나쳐~ 필터
				if(!file.exists()) {
					file.mkdirs();
				}
				// 최종으로 업로드된 파일을 저장할 위치 선정(위치 + 파일명)
				saveLocate = saveLocate + "/" + boNo + "/" + saveName + "." + endFilename; // 셋팅을 해둠/  boNo 어떤 게시글인지 직관적확인으로 구분/ . 기준으로 확장자! 확장성을 가지고 수정필요시하려고!
				File saveFile = new File(saveLocate); // 그녀석을 파일객체로 만들어서 담아둠
				
				// db에 파일에서 얻어온 정보를 가지고 추가하기 위한
				noticeFileVO.setBoNo(boNo);
				noticeFileVO.setFileSavepath(saveLocate);
				noticeMapper.insertNoticeFile(noticeFileVO);
				
				// 내가선정한 그 서버에 업로드하기 위한
				InputStream is = noticeFileVO.getItem().getInputStream();
				FileUtils.copyInputStreamToFile(is, saveFile);
				is.close();
				
			}
		}
		
	}
	
	public static void deleteFolder(HttpServletRequest req, String path) { // 폴더 드가고! 자료 확인후 자료 지우고 폴더삭제 순서로 진행됨
		File folder = new File(path);
		
		try {
			if (folder.exists()) {
				File[] folderList = folder.listFiles();
				
				for (int i = 0; i < folderList.length; i++) {
					if (folderList[i].isFile()) {
						folderList[i].delete();
					}else {
						deleteFolder(req, folderList[i].getPath());
					}
					folderList[i].delete();
				}
				folder.delete();	// 폴더삭제
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Override
	public NoticeFileVO noticeDownload(int fileNo) {
		NoticeFileVO noticeFileVO = noticeMapper.noticeDownload(fileNo);
		if (noticeFileVO == null) {
			throw new RuntimeException();
		}
		noticeMapper.incrementNoticeDowncount(fileNo);
		return noticeFileVO;
	}



	
	
	
	
	
	
	
}






















