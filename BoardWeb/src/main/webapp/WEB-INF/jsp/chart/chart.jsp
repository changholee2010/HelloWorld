<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {
			  // ajax.
			  fetch('chart.do')
			  .then(data => data.json())
			  .then(result => {
				  console.log(result);//[{},{}...{}]
				  let dataAry = [];//[[],[]..[]]
				  dataAry.push(['작성자', '건수']);
				  result.forEach(function(item){
					  dataAry.push([item.memberName, item.cnt]);
				  })
				  console.log(dataAry);
				  //
				  var data = google.visualization.arrayToDataTable(dataAry);
          var options = {
            title: '사용자별 게시건수'
          };
          var chart = new google.visualization.PieChart(document.getElementById('piechart'));
          chart.draw(data, options);
				  
			  })
			  .catch(err => console.log(err));
			  
        
      }
    </script>
  </head>
  <body>
    <div id="piechart" style="width: 900px; height: 500px;"></div>
  </body>
</html>
