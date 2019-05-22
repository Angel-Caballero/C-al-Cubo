DZ.init({
    appId: "341062",
    channelUrl: "http://c-al-cubo.appspot.com/channel.html",
});

document.getElementById("login").addEventListener("click", () => {
    DZ.login(function(response) {
        console.log("1",response);
    }, {perms: "basic_access,email,offline_access,manage_library,manage_community,delete_library,listening_history"});
});