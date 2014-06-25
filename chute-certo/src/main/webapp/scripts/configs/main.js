require.config({

     paths: {
         'angular': '../libs/angular/angular',
         'angular.route': '../libs/angular/route/angular-route.min',
         'ui.bootstrap':'../libs/angular/angular-ui/ui-bootstrap/ui-bootstrap',
         'ng.grid':'../libs/angular/angular-ui/ui-ng-grid/ng-grid-2.0.7',
         'ng.grid.flexible.height':'../libs/angular/angular-ui/ui-ng-grid/ng-grid-flexible-height',
         'ng.grid.layout':'../libs/angular/angular-ui/ui-ng-grid/ng-grid-layout',
         'ui.select':'../libs/angular/angular-ui/ui-select/select',
         'domReady': '../libs/require/domready/domready',
         'jquery': '../libs/jquery/jquery',
         'angular.animate': '../libs/angular/animate/angular-animate',
         'angular.sanitize': '../libs/angular/sanitize/angular-sanitize.min',
         'angular.strap': '../libs/angular/angular-strap/angular-strap.min',
         'angular.strap.tpl': '../libs/angular/angular-strap/angular-strap.tpl.min',
         'ui.utils':'../libs/angular/angular-ui/ui-utils/ui-utils',
         'angular.validation':'../libs/angular/validation/angular-validation',
         'angular.upload':'../libs/angular/upload/angular-file-upload',
         'utils': '../util/util'
     },
 
     shim: {
    	 'jquery': {
    		 exports: 'jquery'
    	 },
         'angular': {
        	 deps: ['jquery'],
             exports: 'angular'
         },
         'angular.route': {
             deps: ['angular']
         },
         'ui.bootstrap' : {
        	 deps: ['angular']
         },
        'ui.select' : {
        	 deps: ['angular.sanitize']
         },
         'ng.grid' : {
        	 deps: ['angular']
         },
         'ng.grid.flexible.heigh' : {
        	 deps: ['ng.grid']
         },
         'ng.grid.layout' : {
        	 deps: ['ng.grid']
         },
         'ui.utils' : {
        	 deps: ['angular']
         },
         'angular.validation' : {
        	 deps: ['angular']
         },
         'angular.animate' : {
        	 deps: ['angular']
         },
         'angular.sanitize' : {
        	 deps: ['angular']
         },
         'angular.upload': {
             deps: ['angular']
         },
         'angular.strap' : {
        	 deps: ['angular.animate']
         },
         'angular.strap.tpl' : {
        	 deps: ['angular.strap']
         },
     },
 
     deps: ['./bootstrap']
});