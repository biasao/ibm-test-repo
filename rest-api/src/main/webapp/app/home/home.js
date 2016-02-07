'use strict';

angular.module('jsUiApp')
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'app/home/home.html',
        controller: 'HomeController as homeController',
        title : 'Home'
      });
  });
