(function () {
    'use strict';

    angular.module('movieflix')
        .controller('MoviesAdminController', MoviesAdminController);

    MoviesAdminController.$inject = ['movieService', '$routeParams'];

    function MoviesAdminController(movieService, $routeParams) {
        var moviesAdminVm = this;

        moviesAdminVm.changeSort = changeSort;

        init();

        function init() {

            moviesAdminVm.sorter = {
                by: 'title',
                reverse: false
            };

            movieService
                .getMovies()
                .then(function (movies) {
                    moviesAdminVm.movies = movies;
                }, function (error) {
                    console.log(error);
                });

            movieService
                .deleteMovie($routeParams.title, $routeParams)
                .then(function (movie) {
                    console.log(movie.title + ' has been deleted!!');
                }, function (error) {
                    console.log(error);
                });
        }

        function changeSort(prop) {
            moviesAdminVm.sorter.by = prop;
            moviesAdminVm.sorter.reverse = !moviesAdminVm.sorter.reverse;
        }
    }
})();
