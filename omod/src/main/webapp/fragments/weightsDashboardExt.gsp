<% ui.includeJavascript("isanteplusopenmrsintro", "Chart.min.js") %>

<div class="info-section weights">
    <div class="info-header">
        <i class="icon-picture"></i>
        <h3>Weight Graph</h3>
    </div>
    
    <div class="info-body">
    	<canvas id="weightsChart" width="50" height="50"></canvas>
		<script type="text/javascript">
			var weightsValues = ${weightsValues}
			var weightsLabels = ${weightsLabels}
			var chartDataSchema = {
        		labels: weightsLabels,
        		datasets: [{
            		label: '# of Weights',
            		data: weightsValues,
            		backgroundColor: '#009384',
            		borderColor: '#363463',
            		borderWidth: 1
        		}]
    		}
		
			var ctx = document.getElementById("weightsChart");
			var weightsChart = new Chart(ctx, {
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