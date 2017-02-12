'use strict';
angular.module('sysconferApp').controller('carneLoteController', function($scope, $http, $sce, $window) {

	
	
	$scope.getDadosBoleto = function(){
		$http.get('/dadosBoleto',{ cache: false }).
		success(function(dataList) {
		    $scope.dadosBoleto = dataList;
		});
		
	}
	
	$scope.getDadosBoleto();
		
	$scope.salvarDadosBoleto = function() {
		
		$http({
		    url: '/dadosBoleto', 
		    method: "POST",
		    data: $scope.dadosBoleto
		 }).success(function (response) {
			 alert("Dados salvo com sucesso");
		 });
		
	}
	



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

				    
				    var a = document.createElement("a");
				    document.body.appendChild(a);
				    a.style = "display: none";
				    
				        var blob = new Blob([response], {type: "application/pdf"}),
				            url = window.URL.createObjectURL(blob);
				        a.href = url;
				        a.download = fileName;
				        a.click();
				        window.URL.revokeObjectURL(url);
				    
				       $scope.$emit('UNLOAD')
				       //$scope.$digest();
				       
				  }).error(function (message){
					  $scope.$emit('UNLOAD')
					 // $scope.$digest();
					  alert("Erro ao gerar lote. " + message);
					  
				  });
	  }
	  
	  
	})
	.controller('appController',['$scope',function($scope){
	$scope.$on('LOAD',function(){$scope.loading=true});
	$scope.$on('UNLOAD',function(){$scope.loading=false});
}])

