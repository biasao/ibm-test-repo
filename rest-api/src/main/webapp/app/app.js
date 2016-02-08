'use strict';

angular.module('jsUiApp', [
  'ngRoute',
  'kendo.directives',
  'ngCookies'
])
  .constant("serverURL", {
    "url": "http://" + window.location.hostname
  })

  .config(function ($routeProvider, $locationProvider) {
    $routeProvider
      .otherwise({
        redirectTo: '/'
      });

    $locationProvider.html5Mode(true);

  })

  

