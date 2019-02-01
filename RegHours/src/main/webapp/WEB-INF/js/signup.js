
$(function() {
    
    $('form[name="signup-form"]').on("submit", function() {
        
        let data = $(document).forms['signup-form'];
        
        alert(`Username: ${data.username}`);
        
    });
    
});

function signup(f) {
    
    alert("Entered on method 'signup()'");
    
    
    
}

