define([ './_module' ], function(directives) {
	'use strict';

	directives.directive('ngBlur', [ function() {
		var BLUR_CLASS = "ng-blured";
		return {
			restrict : 'A',
			require : 'ngModel',
			link : function(scope, element, attrs, ctrl) {
				console.log('OPA');
				ctrl.$blured = false;
				element.bind('focus', function(evt) {
					element.removeClass(BLUR_CLASS);
					scope.$apply(function() {
						ctrl.$blured = false;
					});
				}).bind('blur', function(evt) {
					element.addClass(BLUR_CLASS);
					scope.$apply(function() {
						ctrl.$blured = true;
					});
				});
			}
		};
	}]);
});