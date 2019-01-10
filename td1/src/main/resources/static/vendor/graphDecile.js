//get nb salaries in data
var nbColonnes = document.getElementById('graph1').getElementsByTagName('tr').length;
var min = document.getElementById('graph1').getElementsByTagName('td')[1].innerHTML;
var max = document.getElementById('graph1').getElementsByTagName('td')[nbColonnes-2].innerHTML;
var decile = (max-min)/10;
var tabInterval = [0,0,0,0,0,0,0,0,0]
for(var i = 0; i<10 ; i++){
    var interval = decile*(i+1) + parseInt(min);
    tabInterval[i] = interval;
}
var tabSalary = [0,0,0,0,0,0,0,0,0,0];
//Split employees in 10 intervals 2100/4290 to 21810/24000
for(var i = 0 ; i < nbColonnes - 1 ; i++){
    var valueCell = document.getElementById('graph1').getElementsByTagName('td')[i].innerHTML;
    if(valueCell <= tabInterval[0]){
        tabSalary[0] += 1;
    }
    else{
        if(valueCell <= tabInterval[1]){
            tabSalary[1] += 1;
        }
        else{
            if(valueCell <= tabInterval[2]){
                tabSalary[2] += 1;
            }
            else{
                if(valueCell <= tabInterval[3]){
                    tabSalary[3] += 1;
                }
                else{
                    if(valueCell <= tabInterval[4]){
                        tabSalary[4] += 1;
                    }
                    else{
                        if(valueCell <= tabInterval[5]){
                            tabSalary[5] += 1;
                        }
                        else{
                            if(valueCell <= tabInterval[6]){
                                tabSalary[6] += 1;
                            }
                            else{
                                if(valueCell <= tabInterval[7]){
                                    tabSalary[7] += 1;
                                }
                                else{
                                    if(valueCell <= tabInterval[8]){
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
        labels: ["[" + parseInt(min) + "-" + tabInterval[0] +"]","]" + tabInterval[0]+ "-" + tabInterval[1]+"]","]" + tabInterval[1] + "-" + tabInterval[2]+"]","]" + tabInterval[2] + "-" + tabInterval[3]+"]","]" + tabInterval[3] + "-" + tabInterval[4]+"]","]" + tabInterval[4] + "-" + tabInterval[5]+"]","]" + tabInterval[5] + "-" + tabInterval[6]+"]","]" + tabInterval[6] + "-" + tabInterval[7]+"]","]" + tabInterval[7] + "-" +tabInterval[8]+"]","]" + tabInterval[8] + "-" + tabInterval[9]+"]"],
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