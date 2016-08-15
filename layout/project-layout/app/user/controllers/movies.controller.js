(function () {
    'use strict';

    angular.module('movieflix')
        .controller('MoviesController', MoviesController);

    MoviesController.$inject = ['movieService'];

    function MoviesController(movieService) {
        var moviesVm = this;

        moviesVm.changeSort = changeSort;

        init();

        function init() {

            moviesVm.sorter = {
                by: 'title',
                reverse: false
            };

            movieService
                .getMovies()
                .then(function (movies) {
                    moviesVm.movies = movies;
                }, function (error) {
                    console.log(error);
                });
        }

        function changeSort(prop) {
            moviesVm.sorter.by = prop;
            moviesVm.sorter.reverse = !moviesVm.sorter.reverse;
        }
    }
})();
