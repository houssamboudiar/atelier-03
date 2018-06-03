//window.onload = function () {
//
//var chart = new CanvasJS.Chart("chartContainer", {
//	theme: "light1", // "light2", "dark1", "dark2"
//	animationEnabled: false, // change to true		
//	title:{
//		text: "Basic Column Chart"
//	},
//	data: [
//	{
//		// Change type to "bar", "area", "spline", "pie",etc.
//		type: "column",
//		dataPoints: [
//			{ label: "apple",  y: 10  },
//			{ label: "orange", y: 15  },
//			{ label: "banana", y: 29 },
//			{ label: "mango",  y: 30  },
//			{ label: "grape",  y: 28  },
//            { label: "grape",  y: 28  },
//            { label: "grape",  y: 98  }
//		]
//	}
//	]
//});
//chart.render();
//
//}
//
//
//
//
//window.onload = function () {
//
//	var chart = new CanvasJS.Chart("round", {
//		theme: "light2",
//		animationEnabled: true,
//		title: {
//			text: "Shares of Electricity Generation by Fuel"
//		},
//		subtitles: [{
//			text: "United Kingdom, 2016",
//			fontSize: 16
//		}],
//		data: [{
//			type: "pie",
//			indexLabelFontSize: 18,
//			radius: 80,
//			indexLabel: "{label} - {y}",
//			yValueFormatString: "###0.0\"%\"",
//			click: explodePie,
//			dataPoints: [
//				{ y: 42, label: "Gas" },
//				{ y: 21, label: "Nuclear"},
//				{ y: 24.5, label: "Renewable" },
//				{ y: 9, label: "Coal" },
//				{ y: 3.1, label: "Other Fuels" }
//			]
//		}]
//	});
//	chart.render();
//
//	function explodePie(e) {
//		for(var i = 0; i < e.dataSeries.dataPoints.length; i++) {
//			if(i !== e.dataPointIndex)
//				e.dataSeries.dataPoints[i].exploded = false;
//		}
//	}
//	 
//	}
//
//
//
//
//
//window.onload = function () {
//
//var chart = new CanvasJS.Chart("empty", {
//	theme: "dark2",
//	exportFileName: "Doughnut Chart",
//	exportEnabled: true,
//	animationEnabled: true,
//	title:{
//		text: "Monthly Expense"
//	},
//	legend:{
//		cursor: "pointer",
//		itemclick: explodePie
//	},
//	data: [{
//		type: "doughnut",
//		innerRadius: 90,
//		showInLegend: true,
//		toolTipContent: "<b>{name}</b>: ${y} (#percent%)",
//		indexLabel: "{name} - #percent%",
//		dataPoints: [
//			{ y: 450, name: "Food" },
//			{ y: 120, name: "Insurance" },
//			{ y: 300, name: "Travelling" },
//			{ y: 800, name: "Housing" },
//			{ y: 150, name: "Education" },
//			{ y: 150, name: "Shopping"},
//			{ y: 250, name: "Others" }
//		]
//	}]
//});
//chart.render();
//
//function explodePie (e) {
//	if(typeof (e.dataSeries.dataPoints[e.dataPointIndex].exploded) === "undefined" || !e.dataSeries.dataPoints[e.dataPointIndex].exploded) {
//		e.dataSeries.dataPoints[e.dataPointIndex].exploded = true;
//	} else {
//		e.dataSeries.dataPoints[e.dataPointIndex].exploded = false;
//	}
//	e.chart.render();
//}
//
//}
//
//
//
//window.onload = function() {
//
//	var chart = new CanvasJS.Chart("basic_round", {
//		animationEnabled: true,
//		title: {
//			text: "Desktop Search Engine Market Share - 2016"
//		},
//		data: [{
//			type: "pie",
//			startAngle: 240,
//			yValueFormatString: "##0.00\"%\"",
//			indexLabel: "{label} {y}",
//			dataPoints: [
//				{y: 79.45, label: "Google"},
//				{y: 7.31, label: "Bing"},
//				{y: 7.06, label: "Baidu"},
//				{y: 4.91, label: "Yahoo"},
//				{y: 1.26, label: "Others"}
//			]
//		}]
//	});
//	chart.render();
//
//	}
//
//
//
//
//window.onload = function () {
//
//	var chart = new CanvasJS.Chart("half_empty", {
//		animationEnabled: true,
//		title:{
//			text: "Email Categories",
//			horizontalAlign: "left"
//		},
//		data: [{
//			type: "doughnut",
//			startAngle: 60,
//			//innerRadius: 60,
//			indexLabelFontSize: 17,
//			indexLabel: "{label} - #percent%",
//			toolTipContent: "<b>{label}:</b> {y} (#percent%)",
//			dataPoints: [
//				{ y: 67, label: "Inbox" },
//				{ y: 28, label: "Archives" },
//				{ y: 10, label: "Labels" },
//				{ y: 7, label: "Drafts"},
//				{ y: 15, label: "Trash"},
//				{ y: 6, label: "Spam"}
//			]
//		}]
//	});
//	chart.render();
//
//	}
//
//
//
//window.onload = function () {
//
//	var chart = new CanvasJS.Chart("user_nbr", {
//		animationEnabled: true,
//		theme: "light2",
//		title:{
//			text: "Simple Line Chart"
//		},
//		axisY:{
//			includeZero: false
//		},
//		data: [{        
//			type: "line",       
//			dataPoints: [
//				{ y: 450 },
//				{ y: 414},
//				{ y: 520, indexLabel: "highest",markerColor: "red", markerType: "triangle" },
//				{ y: 460 },
//				{ y: 450 },
//				{ y: 500 },
//				{ y: 480 },
//				{ y: 480 },
//				{ y: 410 , indexLabel: "lowest",markerColor: "DarkSlateGrey", markerType: "cross" },
//				{ y: 500 },
//				{ y: 480 },
//				{ y: 510 }
//			]
//		}]
//	});
//	chart.render();
//
//	}
//
//
//
//window.onload = function () {
//
//	var chart = new CanvasJS.Chart("user_nbr_2", {
//		animationEnabled: true,  
//		title:{
//			text: "Music Album Sales by Year"
//		},
//		axisY: {
//			title: "Units Sold",
//			valueFormatString: "#0,,.",
//			suffix: "mn",
//			stripLines: [{
//				value: 3366500,
//				label: "Average"
//			}]
//		},
//		data: [{
//			yValueFormatString: "#,### Units",
//			xValueFormatString: "YYYY",
//			type: "spline",
//			dataPoints: [
//				{x: new Date(2002, 0), y: 2506000},
//				{x: new Date(2003, 0), y: 2798000},
//				{x: new Date(2004, 0), y: 3386000},
//				{x: new Date(2005, 0), y: 6944000},
//				{x: new Date(2006, 0), y: 6026000},
//				{x: new Date(2007, 0), y: 2394000},
//				{x: new Date(2008, 0), y: 1872000},
//				{x: new Date(2009, 0), y: 2140000},
//				{x: new Date(2010, 0), y: 7289000},
//				{x: new Date(2011, 0), y: 4830000},
//				{x: new Date(2012, 0), y: 2009000},
//				{x: new Date(2013, 0), y: 2840000},
//				{x: new Date(2014, 0), y: 2396000},
//				{x: new Date(2015, 0), y: 1613000},
//				{x: new Date(2016, 0), y: 2821000},
//				{x: new Date(2017, 0), y: 2000000}
//			]
//		}]
//	});
//	chart.render();
//
//	}






var nbr_visitors = document.querySelector(".nbr_all_visites")
var nbr_visitors_client = document.querySelector(".nbr_client_visites")
var percent_visitors_client = document.querySelector(".percent_client_visites")
var nbr_visitors_agent = document.querySelector(".nbr_agent_visites")
var percent_visitors_agent = document.querySelector(".percent_agent_visites")
var nbr_visitors_opertors = document.querySelector(".nbr_operator_visites")
var percent_visitors_opertors = document.querySelector(".percent_operator_visites")


var xhr = new XMLHttpRequest()
xhr.open("GET","http://localhost:8080/statistcs",true);
xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
xhr.send()

xhr.onreadystatechange=function(){
	
	if (xhr.readyState==4 && xhr.status==200){	
		
		r = JSON.parse(xhr.responseText);
		console.log(r)
		
		nbr_visitors.innerHTML = r.nbr_all_website_visites
		nbr_visitors_client.innerHTML = r.nbr_client_website_visites
		percent_visitors_client.innerHTML = r.percent_client_website_visites
		nbr_visitors_agent.innerHTML = r.nbr_agent_website_visites
		percent_visitors_agent.innerHTML = r.percent_agent_website_visites
		nbr_visitors_opertors.innerHTML = r.nbr_operator_website_visites
		percent_visitors_opertors.innerHTML = r.percent_operator_website_visites
		
		
		

			var chart = new CanvasJS.Chart("visitors_nbr", {
				theme:"light2",
				animationEnabled: true,
				title:{
					text: "The Number Of Visitors Per Month"
				},
				axisY :{
					includeZero: true,
					title: "Number of Visitors",
					suffix: ""
				},
				toolTip: {
					shared: "true"
				},
				legend:{
					cursor:"pointer",
					itemclick : toggleDataSeries
				},
				data: [{
					type: "spline",
					visible: true,
					showInLegend: true,
					yValueFormatString: "",
					name: "Clients",
					dataPoints: [
						{ label: "January", y: r.nbr_all_visites_website_by_clients_mounths.January },
						{ label: "February", y: r.nbr_all_visites_website_by_clients_mounths.February },
						{ label: "March", y: r.nbr_all_visites_website_by_clients_mounths.March },
						{ label: "April", y: r.nbr_all_visites_website_by_clients_mounths.April },
						{ label: "May", y: r.nbr_all_visites_website_by_clients_mounths.May },
						{ label: "June", y: r.nbr_all_visites_website_by_clients_mounths.June },
						{ label: "July", y: r.nbr_all_visites_website_by_clients_mounths.July },
						{ label: "August", y: r.nbr_all_visites_website_by_clients_mounths.August },
						{ label: "September", y: r.nbr_all_visites_website_by_clients_mounths.September },
						{ label: "October", y: r.nbr_all_visites_website_by_clients_mounths.October },
						{ label: "November", y: r.nbr_all_visites_website_by_clients_mounths.November },
						{ label: "December", y: r.nbr_all_visites_website_by_clients_mounths.January }
					]
				},
				{
					type: "spline", 
					showInLegend: true,
					visible: true,
					yValueFormatString: "",
					name: "Agent",
					dataPoints: [
						{ label: "January", y: r.nbr_all_visites_website_by_agents_mounths.January },
						{ label: "February", y: r.nbr_all_visites_website_by_agents_mounths.February },
						{ label: "March", y: r.nbr_all_visites_website_by_agents_mounths.March },
						{ label: "April", y: r.nbr_all_visites_website_by_agents_mounths.April },
						{ label: "May", y: r.nbr_all_visites_website_by_agents_mounths.May },
						{ label: "June", y: r.nbr_all_visites_website_by_agents_mounths.June },
						{ label: "July", y: r.nbr_all_visites_website_by_agents_mounths.July },
						{ label: "August", y: r.nbr_all_visites_website_by_agents_mounths.August },
						{ label: "September", y: r.nbr_all_visites_website_by_agents_mounths.September },
						{ label: "October", y: r.nbr_all_visites_website_by_agents_mounths.October },
						{ label: "November", y: r.nbr_all_visites_website_by_agents_mounths.November },
						{ label: "December", y: r.nbr_all_visites_website_by_agents_mounths.January }
					]
				},
				{
					type: "spline",
					visible: true,
					showInLegend: true,
					yValueFormatString: "",
					name: "Operators",
					dataPoints: [
						{ label: "January", y: r.nbr_all_visites_website_by_operators_mounths.January },
						{ label: "February", y: r.nbr_all_visites_website_by_operators_mounths.February },
						{ label: "March", y: r.nbr_all_visites_website_by_operators_mounths.March },
						{ label: "April", y: r.nbr_all_visites_website_by_operators_mounths.April },
						{ label: "May", y: r.nbr_all_visites_website_by_operators_mounths.May },
						{ label: "June", y: r.nbr_all_visites_website_by_operators_mounths.June },
						{ label: "July", y: r.nbr_all_visites_website_by_operators_mounths.July },
						{ label: "August", y: r.nbr_all_visites_website_by_operators_mounths.August },
						{ label: "September", y: r.nbr_all_visites_website_by_operators_mounths.September },
						{ label: "October", y: r.nbr_all_visites_website_by_operators_mounths.October },
						{ label: "November", y: r.nbr_all_visites_website_by_operators_mounths.November },
						{ label: "December", y: r.nbr_all_visites_website_by_operators_mounths.January }
					]
				}
			]
		});
		
		chart.render();

		function toggleDataSeries(e) {
			if (typeof(e.dataSeries.visible) === "undefined" || e.dataSeries.visible ){
				e.dataSeries.visible = false;
			} else {
				e.dataSeries.visible = true;
			}
			chart.render();
		}
		
		
		
		
	}// xhr response end
	
}

//setInterval(function(){
//	xhr.open("GET","http://localhost:8080/statistcs",true);
//	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
//	xhr.send()
//
//	xhr.onreadystatechange=function(){
//		
//		if (xhr.readyState==4 && xhr.status==200){	
//			
//			r = JSON.parse(xhr.responseText);
//			console.log(r)
//			
//			nbr_visitors.innerHTML = r.nbr_all_website_visites
//			nbr_visitors_client.innerHTML = r.nbr_client_website_visites
//			percent_visitors_client.innerHTML = r.percent_client_website_visites
//			nbr_visitors_agent.innerHTML = r.nbr_agent_website_visites
//			percent_visitors_agent.innerHTML = r.percent_agent_website_visites
//			nbr_visitors_opertors.innerHTML = r.nbr_operator_website_visites
//			percent_visitors_opertors.innerHTML = r.percent_operator_website_visites
//			
//		}
//	}
//
//}, 1000)
