<!DOCTYPE html>
<html>
  <head>
    <title>Simple Map</title>
    <meta name="viewport" content="initial-scale=1.0">
    <meta charset="utf-8">
    <style>
      /* Always set the map height explicitly to define the size of the div
       * element that contains the map. */
      #map {
        height: 100%;
      }
      /* Optional: Makes the sample page fill the window. */
      html, body {
        height: 100%;
        margin: 0;
        padding: 0;
      }
    </style>
  </head>
  <body>
    <div id="map"></div>
    <script>
      var map;
      var latlag= {lat: 10.858410, lng: 106.765727}
      function initMap() {
        map = new google.maps.Map(document.getElementById('map'), {
          center: latlag,
          zoom: 12
        });
        
        var marker = new google.maps.Marker({
            position: myLatLng,
            map: map,
            title: 'Hello World!'
          });
        
        
      }
    </script>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA5YyzziI_WwblVhMJkdkiMm9_GYMJ11o4&callback=initMap"
    async defer></script>
  </body>
</html>