//get nb salaries in data
var nbColonnes = document.getElementById('graph1').getElementsByTagName('tr').length;

var tabSalary = [0,0,0,0,0,0,0,0,0,0];
var tabDecile = [2500,5000,7500,10000,12500,15000,17500,20000,22500,25000]
//Split employees in 10 intervals 0-2500 to 22501-25000
for(var i = 0 ; i < nbColonnes - 1 ; i++){
    var valueCell = document.getElementById('graph1').getElementsByTagName('td')[i].innerHTML;
    if(valueCell <= tabDecile[0]){
        tabSalary[0] += 1;
    }
    else{
        if(valueCell <= tabDecile[1]){
            tabSalary[1] += 1;
        }
        else{
            if(valueCell <= tabDecile[2]){
                tabSalary[2] += 1;
            }
            else{
                if(valueCell <= tabDecile[3]){
                    tabSalary[3] += 1;
                }
                else{
                    if(valueCell <= tabDecile[4]){
                        tabSalary[4] += 1;
                    }
                    else{
                        if(valueCell <= tabDecile[5]){
                            tabSalary[5] += 1;
                        }
                        else{
                            if(valueCell <= tabDecile[6]){
                                tabSalary[6] += 1;
                            }
                            else{
                                if(valueCell <= tabDecile[7]){
                                    tabSalary[7] += 1;
                                }
                                else{
                                    if(valueCell <= tabDecile[8]){
                                        tabSalary[8] += 1;
                                    }
                                    else{
                                        tabSalary[9] += 1;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

//Convert in percentage
for(var i = 0; i<10 ; i++){
    tabSalary[i] = tabSalary[i]*100/nbColonnes;
}


var ctx = document.getElementById("myChart").getContext('2d');
var myChart = new Chart(ctx, {
    type: 'bar',
    data: {
        labels: ["0-2500","2501-5000","5001-7500","7501-10000","10001-12500","12501-15000","15001-17500","17501-20000","20001-22500","22501-25000"],
        datasets: [{
            label: 'Division of salaries in intervals, in percentage',
            data: tabSalary,
            backgroundColor: [
                'rgba(255, 159, 64, 0.2)',
                'rgba(75, 192, 192, 0.2)',
                'rgba(255, 159, 64, 0.2)',
                'rgba(255, 206, 86, 0.2)',
                'rgba(255, 99, 132, 0.2)',
                'rgba(255, 99, 132, 0.2)',
                'rgba(255, 99, 132, 0.2)',
                'rgba(255, 99, 132, 0.2)',
                'rgba(255, 99, 132, 0.2)',
                'rgba(255, 99, 132, 0.2)'

            ],
            borderColor: [
                'rgba(255, 159, 64, 1)',
                'rgba(75, 192, 192, 1)',
                'rgba(255, 159, 64, 1)',
                'rgba(255, 206, 86, 1)',
                'rgba(255,99,132,1)',
                'rgba(255,99,132,1)',
                'rgba(255,99,132,1)',
                'rgba(255,99,132,1)',
                'rgba(255,99,132,1)',
                'rgba(255,99,132,1)'
            ],
            borderWidth: 1
        }]
    },
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