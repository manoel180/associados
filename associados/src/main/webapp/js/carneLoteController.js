'use strict';
angular.module('sysconferApp').controller('carneLoteController', function($scope, $http, $sce, $window) {

	  $scope.gerarBoleto = function() {
		  $scope.$emit('LOAD');
		 		  $http({
			    url: '/boleto', 
			    method: "POST",
			    data: $scope.lote,
		  		responseType:'arraybuffer'
			 }).success(function (response) {
				 var fileName = "boleto.pdf";
				 
				 var ieEDGE = navigator.userAgent.match(/Edge/g);
				    var ie = navigator.userAgent.match(/.NET/g); // IE 11+
				    var oldIE = navigator.userAgent.match(/MSIE/g); 

				    var blob = new window.Blob([response], { type: 'application/pdf' });

				    if (ie || oldIE || ieEDGE) {
				       window.navigator.msSaveBlob(blob, fileName);
				    }
				    else {
				       var reader = new window.FileReader();
				       reader.onloadend = function () {
				    	   var myWindow = $window.open('', '', 'width=800, height=600');
				    	   myWindow.location.href = reader.result;
				       };
				       reader.readAsDataURL(blob);
				    }
				 
				       $scope.$emit('UNLOAD')
				       //$scope.$digest();
				       
				  }).error(function (message){
					  $scope.$emit('UNLOAD')
					 // $scope.$digest();
					  alert("Erro ao gerar lote");
					  
				  })
				  ;
	  }
	  
	})
	.controller('appController',['$scope',function($scope){
	$scope.$on('LOAD',function(){$scope.loading=true});
	$scope.$on('UNLOAD',function(){$scope.loading=false});
}])

