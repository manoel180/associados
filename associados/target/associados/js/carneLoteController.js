'use strict';
angular.module('sysconferApp').controller('carneLoteController', function($scope, $http, $sce) {

	  $scope.gerarBoleto = function() {
		 		  $http({
			    url: '/boleto', 
			    method: "POST",
			    data: $scope.lote,
		  		responseType:'arraybuffer'
			 }).success(function (response) {
				       var file = new Blob([(response)], {type: 'application/pdf'});
				       var fileURL = URL.createObjectURL(file);
				       $scope.content = $sce.trustAsResourceUrl(fileURL);
				  });
	  }
	});