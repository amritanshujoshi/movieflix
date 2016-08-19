(function () {
    'use strict';

    angular.module('movieflix')
        .controller('SeriesTopRatedController', SeriesTopRatedController);

    SeriesTopRatedController.$inject = ['movieService'];

    function SeriesTopRatedController(movieService) {
        var seriesTopRatedVm = this;

        seriesTopRatedVm.changeSort = changeSort;

        init();

        function init() {

            seriesTopRatedVm.sorter = {
                by: 'imdbRating',
                reverse: true
            };

            movieService
                .getTopRatedSeries()
                .then(function (movies) {
                    seriesTopRatedVm.movies = movies;
                }, function (error) {
                    console.log(error);
                });
        }

        function changeSort(prop) {
            seriesTopRatedVm.sorter.by = prop;
            seriesTopRatedVm.sorter.reverse = !seriesTopRatedVm.sorter.reverse;
        }
    }
})();
