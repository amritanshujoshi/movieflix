(function () {
    'use strict';

    angular.module('movieflix')
        .controller('MoviesTopRatedController', MoviesTopRatedController);

    MoviesTopRatedController.$inject = ['movieService'];

    function MoviesTopRatedController(movieService) {
        var moviesTopRatedVm = this;

        moviesTopRatedVm.changeSort = changeSort;

        init();

        function init() {

            moviesTopRatedVm.sorter = {
                by: 'title',
                reverse: false
            };

            movieService
                .getTopRatedMovies()
                .then(function (movies) {
                    moviesTopRatedVm.movies = movies;
                }, function (error) {
                    console.log(error);
                });
        }

        function changeSort(prop) {
            moviesTopRatedVm.sorter.by = prop;
            moviesTopRatedVm.sorter.reverse = !moviesTopRatedVm.sorter.reverse;
        }
    }
})();
