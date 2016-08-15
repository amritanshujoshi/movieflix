(function () {
    'use strict';

    angular.module('movieflix')
        .controller('MoviesTopVotedController', MoviesTopVotedController);

    MoviesTopVotedController.$inject = ['movieService'];

    function MoviesTopVotedController(movieService) {
        var moviesTopVotedVm = this;

        moviesTopVotedVm.changeSort = changeSort;

        init();

        function init() {

            moviesTopVotedVm.sorter = {
                by: 'title',
                reverse: false
            };

            movieService
                .getTopVotedMovies()
                .then(function (movies) {
                    moviesTopVotedVm.movies = movies;
                }, function (error) {
                    console.log(error);
                });
        }

        function changeSort(prop) {
            moviesTopVotedVm.sorter.by = prop;
            moviesTopVotedVm.sorter.reverse = !moviesTopVotedVm.sorter.reverse;
        }
    }
})();
