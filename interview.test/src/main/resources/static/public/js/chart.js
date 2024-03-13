
 /**
  * Example taken from https://www.chartjs.org/docs/latest/
  * Override this for the interview test
  */

 const MAX_DATA_POINTS = 15;
 const UPDATE_INTERVAL_MS = 2000;

 var ctx = document.getElementById('temperature_line_chart').getContext('2d');
 var temperatureData = {
     labels: [],
     datasets: [{
         label: 'Temperature',
         data: [],
         backgroundColor: 'rgba(255, 99, 132, 0.2)',
         borderColor: 'rgba(255, 99, 132, 1)',
         borderWidth: 1
     }]
 };

 var myChart = new Chart(ctx, {
     type: 'line',
     data: temperatureData,
     options: {
         scales: {
             yAxes: [{
                 ticks: {
                     beginAtZero: true
                 }
             }]
         }
     }
 });

 // Function to format the timestamp into a readable date and time
 function formatDateTime(timestamp) {
     const date = new Date(timestamp);

     const year = date.getFullYear();
     const month = (date.getMonth() + 1 < 10 ? '0' : '') + (date.getMonth() + 1);
     const day = (date.getDate() < 10 ? '0' : '') + date.getDate();

     const hours = (date.getHours() < 10 ? '0' : '') + date.getHours();
     const minutes = (date.getMinutes() < 10 ? '0' : '') + date.getMinutes();
     const seconds = (date.getSeconds() < 10 ? '0' : '') + date.getSeconds();

     const formattedDate = `${year}-${month}-${day}`;
     const formattedTime = `${hours}:${minutes}:${seconds}`;

     return { formattedDate, formattedTime };
 }

 function updateChartData() {
     fetch('api/temperature/current')
         .then(response => response.json())
         .then(data => {

             const { formattedDate, formattedTime } = formatDateTime(data.timestamp);
             temperatureData.labels.push(formattedTime);
             temperatureData.datasets[0].data.push(data.value);
             myChart.data.datasets[0].label = `Temperature on ${formattedDate}`;

             // Ensure maximum of 15 data points
             if (temperatureData.labels.length > MAX_DATA_POINTS) {
                 temperatureData.labels.shift();
                 temperatureData.datasets[0].data.shift();
             }

             myChart.update();
         });
 }

 // Update data every 2 seconds
 setInterval(updateChartData, UPDATE_INTERVAL_MS);
