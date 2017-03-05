var app = angular.module('app', ['ui.grid', 'ui.grid.edit']);

app.controller('MainCtrl', ['$scope', function ($scope) {
   $scope.data = [
     { name: 'Bob', title: 'CEO' },
         { name: 'Frank', title: 'Lowly Developer' }
   ];

   $scope.columnDefs = [
     {name: 'name', enableCellEdit: true},
     {name: 'title', enableCellEdit: true}
   ];
 }]);
