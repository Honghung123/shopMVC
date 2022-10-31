<%@include file="components/header.jsp" %>
<div class="main">
    <div class="content">
        <h3 class="text-danger w-100 bg-colorful text-center">${masages}</h3>
        <div class="d-flex justify-content-center border border-2 rounded p-3 mb-5 form-login">
            <div class="w-75">
                <h3 class="text-center">Existing Customers</h3>
                <p class="text-center">Sign in with the form below.</p>
                <form action="login" method="post">
                    <div class="mb-3">
                        <label for="username" class="form-label">Username</label>
                        <input type="text" class="form-control" id="username" name="username">
                    </div>
                    <div class="mb-3">
                        <label for="exampleInputPassword1" class="form-label">Password</label>
                        <input type="password" class="form-control" id="exampleInputPassword1" name="password">
                    </div>
                    <p class="note text-center">If you forgot your password just enter your email and click <a href="#">here</a>
                    </p>
                    <p class="note text-center">If you don't have account. <a href="#"
                                                                              class="switch_to_register text-danger">Register</a>
                    </p>
                    <button type="submit" class="btn btn-primary btn-centered">Login</button>
                </form>
            </div>
        </div>
        <div class="d-flex justify-content-center  p-3 mb-5 border border-2 form-register d-none">
            <div class="w-100">
                <h3 class="text-center mb-3">Register New Account</h3>
                <form action="register" method="post">
                    <div class="row">
                        <div class="col-md-6">
                            <input type="text" name="name" placeholder="Enter your name" class="form-control mb-2">
                            <input type="text" name="username" placeholder="Enter your username"
                                   class="form-control mb-2">
                            <input type="text" name="phone" placeholder="Enter your phone" class="form-control mb-2">
                            <input type="email" name="email" placeholder="Enter your email" class="form-control mb-2">

                        </div>
                        <div class="col-md-6">
                            <div class="mb-2">
                                <select id="country_rest_api" name="country" class="form-control">
                                    <option value="null">------- Select a Country -------</option>
                                </select>
                            </div>
                            <div class="mb-2">
                                <select id="region_rest_api" name="province" class="form-control">
                                    <option value="null">------- Select a Province -------</option>
                                </select>
                            </div>
                            <input type="text" name="address" placeholder="Enter your address"
                                   class="form-control mb-2">
                            <input type="text" name="image" placeholder="Enter your image link"
                                   class="form-control mb-2">
                            <input type="text" name="password" placeholder="Enter your password"
                                   class="form-control mb-2">
                        </div>
                    </div>
                    <p class="mt-3 mb-3 text-center">By clicking 'Create Account' you agree to the <a href="#">Terms
                        &amp; Conditions</a>.</p>
                    <p class="mt-3 mb-3 text-center">Already have account. <a href="#"
                                                                              class="text-danger switch_to_login">Login
                        here</a>.</p>
                    <input class="btn btn-warning mb-3 btn-centered" type="submit" value="Register">
                    <div class="clear"></div>
                </form>
            </div>
        </div>
        <div class="clear"></div>
    </div>

    <%--	 JQuery for form  --%>
    <script type="text/javascript">
        $(document).ready(function () {
            const formLogin = $(".form-login")[0];
            const fromRegister = $(".form-register")[0];
            const switchLogin = $(".switch_to_login")[0];
            const switchRegister = $(".switch_to_register")[0];
            switchLogin.onclick = function (e) {
                e.preventDefault();
                fromRegister.classList.add("d-none");
                formLogin.classList.remove("d-none");
            }
            switchRegister.onclick = function (e) {
                e.preventDefault();
                fromRegister.classList.remove("d-none");
                formLogin.classList.add("d-none");
            }
        });
    </script>
</div>
<%@include file="components/footer.jsp" %>