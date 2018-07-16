function otherrows(raiders, nofcolumns, row, rown){
  for (i=0; i<nofcolumns; i++) {
        var cell = row.insertCell(i);
          if (i===0){
            createCell1(cell, row, i, raiders, rown)
      } else if (i===1) {
        cell.innerHTML = raiderObjects[rown-1].roleN;
      } else {
          createCell(cell, rown, i)
        }} i = rown
}
function createCell1(cell, row, i, raiders, rown){
  RowId = row;
  cell.innerHTML =
  "<button class ='accDec' onclick='setAcc(this)' id=('accepted' + RowId)><i class='fa fa-check' style='color:DarkSeaGreen'></i></button>"+
  "<button class ='accDec' onclick='setDec(this)' id=('declined' + RowId)><i class='fa fa-close' style='color:darkslategray'></i></button>"+
  "<button id=('nameText' + RowId) class='RnameText'>"+raiderObjects[rown-1].nameN+"</button>";
  cell.style.width="130px";
}
function createCell(cell, rown, i) {
  cellid = "r" + [rown] + "c" + [i];
  setdraftid = "setDraftStatus" + cellid;
  cell.innerHTML =
  "<button id="+setdraftid+" class='tbutton' onclick='setDraftStatus(this," + rown +", "+ i + ")'></button>" +
  "<button class='sitButton' id=('setStandby' + cellid) onclick='setAsStandby(this,"+i+", "+rown+")'></button>";
  document.getElementById(setdraftid).innerText = "-";
}
function setAsStandby(button, i, rown) {
  var standbyTicked = button.parentElement.getElementsByClassName("tbutton")[0];
  standbyTicked.style.backgroundColor = "darkslategray";
  standbyTicked.innerText = "standby";
  standbyTicked.style.color = "white";
  var table = document.getElementById("draftTable");
  table.rows[rown].cells[i].class ="standbyclass";
  var cellnu = i;
  counterTableShow(cellnu);
}
function setColour(varName, bcCol, textCol, borderCol) {
  varName.style.backgroundColor = bcCol;
  varName.style.border = borderCol;
  varName.style.color = textCol;
}
function setAcc(button) {
  var varName = button.parentElement.getElementsByClassName("RnameText")[0];
  if (varName.style.backgroundColor == "darkseagreen") {
    var bcCol = "white";
    var textCol = "black";
    var borderCol = "white";
        button.parentElement.class = "notchosen";
    setColour(varName, bcCol, textCol, borderCol)
  } else {
    var bcCol = "DarkSeaGreen";
    var textCol = "white";
    var borderCol = "DarkSeaGreen";
        button.parentElement.class = "acces";
    setColour(varName, bcCol, textCol, borderCol)
  }}
function setDec(button){
  var varName = button.parentElement.getElementsByClassName("RnameText")[0];
  if (varName.style.backgroundColor == "darkslategray") {
    var bcCol = "white";
    var textCol = "black";
    var borderCol = "white";
    button.parentElement.class = "notchosen";
    setColour(varName, bcCol, textCol, borderCol)
  } else {
    var bcCol = "darkslategray";
    var textCol = "white";
    var borderCol = "darkslategray";
    button.parentElement.class = "decl";
    setColour(varName, bcCol, textCol, borderCol)
  }}
function createfirstrow(bosses, nofcolumns, row, rown){
  for (i=0; i<nofcolumns; i++) {
    var cell = row.insertCell(i);
      if (i===0){
        cell.innerHTML = "";
      } else if (i===1){
        cell.innerHTML = "R";
      } else
    cell.innerHTML = bosses[i-2].Bname;
    cell.style.textAlign="center";
    cell.style.height="50px";
  } i = rown
}
function createTable(bosses){
    var table = document.getElementById("draftTable");
    var raiders = ["Vala", "Haseo", "Ilnezhara"];
    var nofrows = raiderObjects.length + 1;
    var nofcolumns = bosses.length + 2;
    for (i=0; i<nofrows; i++){
      var rown = i
      var row = table.insertRow(i);
      if (i === 0) {
        createfirstrow(bosses, nofcolumns, row, rown)
      } else {
        otherrows(raiders, nofcolumns, row, rown)
      }
    }}
function setDraftStatus(button, rown, i){
    var cellnu = i;
      var table = document.getElementById("draftTable");
      table.rows[rown].cells[i].class ="notstandby";
      counterTableShow(cellnu);
      var vala = raiderObjects[rown-1].offroleN;
      var raiderStatus = button
      raiderStatus.style.color = "black";
      if (raiderStatus.innerText === "DPS") {
        if ((vala.charAt(3)) === "1") {
          raiderStatus.innerText = "tank";
          raiderStatus.style.backgroundColor = "lightgray";
        } else if ((vala.charAt(2)) === "1") {
          raiderStatus.innerText = "healer";
          raiderStatus.style.backgroundColor = "DarkSeaGreen";
        } else {
            raiderStatus.innerText = "-";
            raiderStatus.style.backgroundColor = "white";
      }} else if (raiderStatus.innerText === "tank") {
            if ((vala.charAt(2)) === "1") {
            raiderStatus.innerText = "healer";
            raiderStatus.style.backgroundColor = "DarkSeaGreen";
          } else {
          raiderStatus.innerText = "-";
          raiderStatus.style.backgroundColor = "white";
      }} else if (raiderStatus.innerText === "-") {
      raiderStatus.innerText = "x";
      raiderStatus.style.backgroundColor = "lavender";
    } else if (raiderStatus.innerText === "x") {
        if ((vala.charAt(0)) === "1" || (vala.charAt(1)) === "1") {
        raiderStatus.innerText = "DPS";
        raiderStatus.style.backgroundColor = "lightblue";
      } else if ((vala.charAt(3)) === "1") {
        raiderStatus.innerText = "tank";
        raiderStatus.style.backgroundColor = "lightgray";
      } else if ((vala.charAt(2)) === "1") {
        raiderStatus.innerText = "healer";
        raiderStatus.style.backgroundColor = "DarkSeaGreen";
    } else {
        raiderStatus.innerText = "-";
        raiderStatus.style.backgroundColor = "white";
  }} else {
        raiderStatus.innerText = "-";
        raiderStatus.style.backgroundColor = "white";
    }}
function showDeclined(){
  var table = document.getElementById("draftTable");
  var nofr = table.rows.length;
  for (i=1; i<nofr; i++){
      table.rows[i].style.display = "";
    }
    document.getElementById("numAcc").innerText = "";
}
function sortTable(){
  var table, rows, switching, i, x, y, shouldSwitch;
  table = document.getElementById("draftTable");
  switching = true;
  while (switching) {
    switching = false;
    rows = table.getElementsByTagName("TR");
    for (i=1; i< (rows.length -1); i++) {
      shouldSwitch = false;
      x = rows[i].getElementsByTagName("TD")[1];
      y = rows[i + 1].getElementsByTagName("TD")[1];
      if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
        shouldSwitch = true;
        break;
      }
    } if (shouldSwitch) {
      rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
      switching = true;
    }
  }
}
function separateHealers(){
  var table, rows, columns, i, x, y, z;
  table = document.getElementById("draftTable");
  rows = table.getElementsByTagName("TR");
  columns = document.getElementById('draftTable').rows[0].cells.length;
  healcol = "#c3a2a2";
    for (i=1; i< (rows.length -1); i++) {
      numb = i;
      x = rows[i].getElementsByTagName("TD")[1];
      y = rows[i + 1].getElementsByTagName("TD")[1];
      if (x.innerHTML ==="tank" && y.innerHTML ==="healer") {
        var firstHealer = i + 1;
        for (i=1; i<columns; i++) {
          z = rows[firstHealer].getElementsByTagName("TD")[i];
          z.style.backgroundColor= healcol;
        } i = numb;
      } else if (x.innerHTML ==="healer" && y.innerHTML ==="DPSx") {
      var lastHealer = i;
      for (i=1; i<columns; i++) {
        z = rows[numb].getElementsByTagName("TD")[i];
        z.style.backgroundColor= healcol;
      } i = numb;
    } else if (x.innerHTML === "healer"){
      for (i=1; i<columns; i++) {
        z = rows[numb].getElementsByTagName("TD")[i];
        z.style.backgroundColor= healcol;
    } i = numb;
  }
}}
function hideRoleColumn(){
  var table = document.getElementById("draftTable");
  var nofr = table.rows.length;
  for (i=0; i<nofr; i++){
    table.rows[i].cells[1].style.display = "none";
}}
function tableLoad(){
  createTable(bossObjectArray);
  sortTable();
  separateHealers();
  hideRoleColumn();
  createCountertable();
  createTierList();
  updateNtoSit();
}
function showBossColumn(saveBosses){
  var table = document.getElementById("draftTable");
  var nofr = table.rows.length;
  for (i=0; i<bossObjectArray.length; i++) {
    bossi = bossObjectArray[i];
    cell = i + 2;
  if (saveBosses.includes(bossi.Bname) == false){
  hideColumn(cell);
  i = cell -2;
  }}}
function hideColumn(cell){
  var table = document.getElementById("draftTable");
  var nofr = table.rows.length;
  for (i=0; i<nofr; i++){
    table.rows[i].cells[cell].style.display = "none";
}}
function hideDeclined(){
  var table = document.getElementById("draftTable");
  var nofr = table.rows.length;
  var numAcce = 0;
  for (i=1; i<nofr; i++){
    var cellstatus = table.rows[i].cells[0];
    if (cellstatus.class === "decl") {
      table.rows[i].style.display = "none";
    } else if(cellstatus.class === "acces") {
      numAcce = numAcce + 1;
    }  }
  document.getElementById("totacc").innerText = "Accepted: " + numAcce;
  document.getElementById("totacc").value = numAcce;
  updateNtoSit();
}
function updateNtoSit(){
  var table = document.getElementById("draftTable");
  var nofr = table.rows.length;
  columns = table.rows[0].cells.length;
  for (i=2; i<columns; i++){
  cellv = table.rows[nofr-1].cells[i];
  if (typeof cellv.value !='undefined') {
  numSby = cellv.value;
  } else {
  numSby = 0;
  } totnum = document.getElementById("totacc").value;
  if (typeof totnum ==='undefined') {
  totnum = 0;
  } cellv.innerHTML = totnum - 20 - numSby;
  checkifnegative(cellv);}
  }
function createCountertable(){
  var table = document.getElementById('draftTable');
  var nofr = table.rows.length;
  row = table.insertRow(nofr);
  columns = table.rows[0].cells.length;
  for (i=0; i<columns; i++) {
      var cell = row.insertCell(i);
      cell.class = "counttable"
    if (i===0) {
    cell.id="totacc";
  } else if (i===1) {
  cell.style.display = "none"; }
}}
function counterTableShow(cellnu){
  var table = document.getElementById("draftTable");
  var nofr = table.rows.length;
  var numSby = 0;
  for (i=1; i<nofr-1; i++){
    var cellstatus = table.rows[i].cells[cellnu];
    if (cellstatus.class === "standbyclass") {
      numSby = numSby + 1;
    }}
  totnum = document.getElementById("totacc").value;
  if (typeof totnum === 'undefined') {
    totnum = 0;
  }
  var countcell = table.rows[nofr-1].cells[cellnu];
  countcell.innerHTML = totnum - 20 - numSby;
  countcell.value = numSby;
  checkifnegative(countcell);
  }
function createTierList(){
  var noftiers = tiersArray.length;
  for (i=0; i<noftiers; i++){
    buttonid = "b" + i;
    tiername = tiersArray[i];
    document.getElementById("tierSelection").innerHTML +=
    "<button id="+buttonid+" onclick='showTierBosses(this)'>"+tiername+"</button>"+"<br>"
  } }
function showTierBosses(button){
  i = button.innerHTML;
  tierchosen = tiers[i];
  tiern = "Tier"+i;
  var tierchoices = document.getElementById("tiersBosses");
  tierchoices.innerHTML ="<br>";
  bossesChosen = [];
  for (i=0; i<bossObjectArray.length; i++){
    if (bossObjectArray[i].Btier === tiern){
      checkboxname = "boss" +i;
      idname = bossObjectArray[i].Bname;
    tierchoices.innerHTML +=
    "<input id="+idname+" class='bossCheckBox' type = 'checkbox' name="+checkboxname+">"+idname + " " +"<br>";
    }}
  tierchoices.innerHTML += "<br>" + "<br>" + "<button onclick ='selectBosses()'>Select</button>"
}
function selectBosses(){
  saveBosses = [];
  bossesChosen = document.getElementsByClassName("bossCheckBox");
  for (i=0; i<bossesChosen.length; i++){
    if (bossesChosen[i].checked) {
      bossnam = bossesChosen[i].id;
      saveBosses.push(bossnam);
  }
  } if (saveBosses.length > 0) {
  showBossColumn(saveBosses);
}}
function checkifnegative(cell){
  if (cell.innerHTML <0) {
    cell.innerHTML = "-";
  }
}
