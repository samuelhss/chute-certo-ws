/**
* bootstraps angular onto the window.document node
*/
define([
    'require',
    'angular',
    'plataforma',
    'routes',
    'alerts'
], function (require, angular) {
    'use strict';
 
    require(['domReady!'], function (document) {
        angular.bootstrap(document, ['plataforma']);
    });
});