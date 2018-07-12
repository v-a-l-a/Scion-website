function Tier (tiername){
  this.Tiername = tiername;
}

tiersArray = [];
tierA = "0";
tierObject = new Tier(tierA);
tiersArray.push(tierA);
tierB = "1";
tierObject = new Tier(tierB);
tiersArray.push(tierB);
tierC = "2";
tierObject = new Tier(tierC);
tiersArray.push(tierC);


function StoreRaiderInfo(){
  var raidersName, raidersMS, raidersOS, text;
  offspecoptions = ["OS1", "OS2", "OS3", "OS4"];
  offspecroles = ["melee DPS", "ranged DPS", "healer", "tank"];
  raidersOS = "";
  OScode = ""
  raidersName = document.getElementById("AddedName").value;
  if (document.getElementById("AddedRole1").checked) {
    document.getElementById("OS1").checked=false;
    if (document.getElementById("OS2").checked) {
      raidersMS = "DPSt"
    } else {
    raidersMS = "DPSx";
    }
  } else if (document.getElementById("AddedRole2").checked) {
    document.getElementById("OS2").checked=false;
      if (document.getElementById("OS1").checked) {
        raidersMS = "DPSt"
      } else {
      raidersMS = "DPSr"
    }
    } else if (document.getElementById("AddedRole3").checked) {
      raidersMS = "healer"
      document.getElementById("OS3").checked=false;
    } else {
      raidersMS = "tank";
      document.getElementById("OS4").unchecked=false;
    }
    for (i = 0; i < 4; i++) {
      if (document.getElementById(offspecoptions[i]).checked) {
        raidersOS = raidersOS + offspecroles[i];
        OScode = OScode + "1";
      } else {
      raidersOS = raidersOS;
      OScode = OScode + "0";
    }
  }
  if (raidersOS.length==0) {
  raidersOS = "none";
  OScode = OScode + "1";
  } else {
    raidersOS = raidersOS;
    OScode = OScode + "0";
  }
  if (raidersName.length ==0) {
    text = "Please fill the name";
    } else {
      var raiderobj = new Raider (raidersName, raidersMS, OScode);
      var raiderJSON = JSON.stringify(raiderobj);
    text = "Name: " + raidersName + "<br>" + "Role: " + raidersMS +
    "<br>" + "Other roles: " + raidersOS + "<br>" + "With OS code of: " + OScode + "<br>" + "JSON string:" + raiderJSON;
    document.getElementById("AddRaiderBox").reset();
  } document.getElementById("StoredInfoAsText").innerHTML = text;
  }
function StoreBossInfo(){
  var bossName = document.getElementById("AddedBossName").value;
  tankIDs = ["tanks1", "tanks2", "tanks3", "tanks4"];
  var tankN = [];
  for (i=0; i<4; i++){
  if (document.getElementById(tankIDs[i]).checked){
    tankAmount = i + 1
    tankN.push(tankAmount);
  }
  }
  if (tankN.length == 0) {
  minTanks = 2;
  maxTanks = 2;
  } else {
  minTanks = tankN[0];
  tanksTicked = tankN.length-1;
  maxTanks = tankN[tanksTicked];
  }
  healerIDs = ["healers3", "healers4", "healers5", "healers6"];
  var healerN = [];
  for (i=0; i<4; i++){
  if (document.getElementById(healerIDs[i]).checked){
    healerAmount = i + 3;
    healerN.push(healerAmount);
  }
  }
  if (healerN.length==0){
  minHealers = 4;
  maxHealers = 4;
  } else {
  minHealers = healerN[0];
  healersTicked = healerN.length - 1;
  maxHealers = healerN[healersTicked];
  }
  if (bossName.length==0){
  text = "Please fill the fight name";
  } else {
  text = "Name: " + bossName + "<br>" + "Tanks: " + "min. " + minTanks + " max: " + maxTanks
  + "<br>" + "Healers: " + "min. " + minHealers + " max: " + maxHealers;
  var boss = new Boss(bossname, mintanks, maxtanks, minhealers, maxhealers, tier);
  document.getElementById("AddFightBox").reset();
  }
  document.getElementById("BossInfoAsText").innerHTML=text;
  }
function hide(idText){
  document.getElementById(idText).style.display="none";
  document.getElementById(idText).reset();
  document.getElementById("StoredInfoAsText").style.display="none";
  document.getElementById("BossInfoAsText").style.display="none";
  document.getElementById("tier").style.display="";
  document.getElementById("formDiv").style.display = "none";
}
function toggleBox(idT){
  var aBox = document.getElementById(idT);
  if (aBox.style.display === "none") {
    document.getElementById("AddRaiderBox").style.display = "none";
    document.getElementById("AddFightBox").style.display = "none";
    document.getElementById("tierform").style.display = "none";
    aBox.style.display = "block";
    document.getElementById("formDiv").style.display = "";
  } else {
    aBox.style.display = "none";
    document.getElementById("formDiv").style.display = "none";
  }
}
function addTier(){
 document.getElementById("tierform").style.display="block";
  document.getElementById("tier").style.display="none";
}
function storeTierInfo(){
  var tiername = document.getElementById("tiern").value;
  var tier = new Tier (tiername);
  document.getElementById("tieradd").innerHTML += tier.Tiername;
  hide('tierform');
}
