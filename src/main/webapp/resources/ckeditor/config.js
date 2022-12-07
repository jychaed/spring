/**
 * @license Copyright (c) 2003-2018, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see https://ckeditor.com/legal/ckeditor-oss-license
 */

CKEDITOR.editorConfig = function( config ) {
	// Define changes to default configuration here. For example:
	// config.language = 'kr';
	// config.uiColor = '#AADC6E';
//	config.extraPlugins = 'youtube';
	config.height = 600;
	config.toolbar = [
          { name: 'document', groups: [ 'mode', 'document', 'doctools' ], items: [ 'Source', '-', 'NewPage', 'Preview' ] },
          { name: 'clipboard', groups: [ 'clipboard', 'undo' ], items: [ 'Cut', 'Copy', 'Paste', 'PasteText', 'PasteFromWord', '-', 'Undo', 'Redo' ] },
          { name: 'editing', groups: [ 'find'], items: [ 'Find', 'Replace' ] },
          { name: 'insert', items: [ 'Image', 'Table', 'HorizontalRule', 'Smiley', 'SpecialChar', 'PageBreak' ] },
          '/',
          { name: 'basicstyles', groups: [ 'basicstyles' ], items: [ 'Bold', 'Italic', 'Underline', 'Strike', 'Subscript', 'Superscript' ] },
          { name: 'paragraph', groups: [ 'list', 'indent', 'blocks', 'align' ], items: [ 'NumberedList', 'BulletedList', '-', 'Outdent', 'Indent', '-', 'Blockquote', 'CreateDiv', '-', 'JustifyLeft', 'JustifyCenter', 'JustifyRight', 'JustifyBlock' ] },
          { name: 'links', items: [ 'Link', 'Unlink', 'Anchor' ] },
          '/',
          { name: 'styles', items: [ 'Styles', 'Format', 'Font', 'FontSize' ] },
          { name: 'colors', items: [ 'TextColor', 'BGColor' ] },
          { name: 'tools', items: [ 'Maximize', 'ShowBlocks' ] },
          { name: 'others', items: [ 'Youtube' ] },
          { name: 'about', items: [ 'About' ] }
      ];
	              
      // Toolbar groups configuration.
      config.toolbarGroups = [
          { name: 'document', groups: [ 'mode', 'document', 'doctools' ] },
          { name: 'clipboard', groups: [ 'clipboard', 'undo' ] },
          { name: 'editing', groups: [ 'find', 'selection', 'spellchecker' ] },
          //{ name: 'forms' },
          '/',
          { name: 'basicstyles', groups: [ 'basicstyles', 'cleanup' ] },
          { name: 'paragraph', groups: [ 'list', 'indent', 'blocks', 'align', 'bidi' ] },
          { name: 'links' },
          { name: 'insert' },
          '/',
          { name: 'styles' },
          { name: 'colors' },
          { name: 'tools' },
          { name: 'others' },
          { name: 'about' }
      ];
	
	config.font_defaultLabel = "나눔고딕";
	config.font_names = "굴림;돋움;바탕;궁서;굴림체;돋움체;바탕체;궁서체;나눔고딕;나눔명조;Arial;" +
			"Comic Sans MS;Courier New;Lucida Sans Unicode;monospace;sans-serif;serif;Tahoma;Times New Roman;Verdana;";
	config.enterMode = CKEDITOR.ENTER_BR;
    config.shiftEnterMode = CKEDITOR.ENTER_P;
};