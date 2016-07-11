<% ui.includeJavascript("isanteplusopenmrsintro", "Chart.min.js") %>
<div class="info-section BMI's">
    <div class="info-header">
        <i class="icon-picture"></i>
        <h3>BMI's Graph</h3>
    </div>
    
    <div class="info-body">
    	<canvas id="bmiChart" width="50" height="50"></canvas>
		<script type="text/javascript">
			var bmiValues = ${bmiValues}
			var bmiLabels = ${bmiLabels}
			var chartDataSchema = {
        		labels: bmiLabels,
        		datasets: [{
            		label: '# of BMI',
            		data: bmiValues,
            		backgroundColor: '#009384',
            		borderColor: '#363463',
            		borderWidth: 1
        		}]
    		}
		
			var ctx = document.getElementById("bmiChart");
			var bmiChart = new Chart(ctx, {
    			type: 'line',
    			data: chartDataSchema,
    			options: {
        			scales: {
            			yAxes: [{
                			ticks: {
                    			beginAtZero:true
                			}
            			}]
        			}
    			}
			});
		</script>

    </div>
</div>