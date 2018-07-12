function Raider(id, name, role, offrole){
  this.idN = id;
  this.nameN = name;
  this.roleN = role;
  this.offroleN = offrole;
}
function Boss(bossname, mintanks, maxtanks, minhealers, maxhealers, tier){
  this.Bname = bossname;
  this.Bmintanks = mintanks;
  this.Bmaxtanks = maxtanks;
  this.Bminhealers = minhealers;
  this.Bmaxhealers = maxhealers;
  this.Btier = tier;
}
Tier1 = ["Garothi", "Felhounds", "AHC", "Eonar", "Hasabel"];
Tier2 = ["Imonar", "Kin", "Vari", "Coven"];
Tier3 = ["Aggramar", "Argus"];
tiers = ["Tier1", "Tier2", "Tier3"];
bossObjectArray = [];
for (i=0; i<3; i++){
  if (i===0){
    Tier = ["Garothi", "Felhounds", "AHC", "Eonar", "Hasabel"];
    tierName = "Tier0";
    for (i=0; i <5; i++){
    bossname = Tier[i];
    boss = "Boss" + bossname;
    var boss = new Boss(bossname, 2, 2, 3, 6, tierName)
    bossObjectArray.push(boss);
  }i=0;} else if (i===1){
    Tier = ["Imonar", "Kin", "Vari", "Coven"];
    tierName = "Tier1";
    for (i=0; i <4; i++){
    bossname = Tier[i];
    boss = "Boss" + bossname;
    var boss = new Boss(bossname, 2, 2, 3, 6, tierName)
    bossObjectArray.push(boss);
  }i=1;} else {
    Tier = ["Aggramar", "Argus"];
    tierName = "Tier2";
    for (i=0; i <2; i++){
    bossname = Tier[i];
    boss = "Boss" + bossname;
    var boss = new Boss(bossname, 2, 2, 3, 6, tierName)
    bossObjectArray.push(boss);
  }}}
lines = ["Vala", "healer", "01000"];
line1 = ["Haseo", "DPSr", "00000"];
line2 = ["Bossly", "tank", "10000"];
line3 = ["Ilne", "DPSm", "00010"];
columns = ["Argus", "Aggramar", "Coven"]
raiderObjects = [];
for (i=0; i<5; i++) {
  var raider = "raider" + i;
  if (i === 0){
    lines = ["Vala", "healer", "00100"];
  } else if (i === 1){
    lines = ["Haseo", "DPSr", "00001"];
  } else if (i === 2){
    lines = ["Bossly", "tank", "10000"];
  }  else if (i===3){
    lines = ["Yrall", "healer", "10001"]
  } else {
    lines = ["Ilne", "DPSx", "00010"];
  }
  var raider = new Raider("ID?", lines[0], lines[1], lines[2]);
  raiderObjects.push(raider);
}
function Status(id, rname, bname, status, signup){
  this.id = id;
  this.rname = rname;
  this.bname = bname;
  this.status = status;
  this.signup = signup;
}

function createRaiderStatuses(){
statusArray = [];
bossAmount = bossObjectArray.length;
raiderAmount = raiderObjects.length;
for (i=0; i<bossAmount; i++){
  num = i;
  bname = bossObjectArray[i].Bname;
  for (i=0; i<raiderAmount; i++){
    rname = raiderObjects[i].nameN;
    statusname = bname + rname;
    statusname = new Status(statusname, rname, bname, "-", "-");
    statusArray.push(statusname);
  } i = num;
} printStatuses(statusArray);
}
function printStatuses(statusArray){
  for (i=0; i<statusArray.length; i++){
    ide = statusArray[i].id;
    Raname = statusArray[i].rname;
    Boname = statusArray[i].bname;
    Statt = statusArray[i].status;
    sign = statusArray[i].signup;
  document.getElementById("stat").innerHTML += "<br>" +
  "id: " + ide + " raider: " + Raname + " boss: " + Boname + " status for boss: " +
  Statt + " signup for the raid: " + sign;
  }
}
