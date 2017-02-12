'use strict';
var sysconferApp = angular.module('sysconferApp', [ 'ngRoute','ngAnimate', 'ngMaterial', 'ui.bootstrap' ]);

sysconferApp.config(function($routeProvider) {
    $routeProvider
    .when('/', {
        templateUrl: '/pages/gerarCarnes/carneLote.html',
        controller: 'carneLoteController'
    })
    .when('/dadosBancarios', {
        templateUrl: '/pages/gerarCarnes/dadosBoleto.html',
        controller: 'carneLoteController'
    })
    .when('/carneLote', {
        templateUrl: '/pages/gerarCarnes/carneLote.html',
        controller: 'carneLoteController'
    })

});

sysconferApp.config( function($mdThemingProvider){
	// Configure a dark theme with primary foreground yellow
	$mdThemingProvider.theme('docs-dark', 'default')
	    .primaryPalette('blue')
	    .dark();});

