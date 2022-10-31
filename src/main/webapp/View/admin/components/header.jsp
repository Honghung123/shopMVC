 <%@include file="/Common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <title>Admin</title>
    <link rel="stylesheet" type="text/css" href="/Resources/admin/css/reset.css" media="screen" />
    <link rel="stylesheet" type="text/css" href="/Resources/admin/css/text.css" media="screen" />
    <link rel="stylesheet" type="text/css" href="/Resources/admin/css/grid.css" media="screen" />
    <link rel="stylesheet" type="text/css" href="/Resources/admin/css/layout.css" media="screen" />
    <link rel="stylesheet" type="text/css" href="/Resources/admin/css/nav.css" media="screen" />
    <link href="/Resources/admin/css/table/demo_page.css" rel="stylesheet" type="text/css" />
    <!-- BEGIN: load jquery -->
    <script src="https://code.jquery.com/jquery-3.6.1.js" integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI=" crossorigin="anonymous"></script>
    <script type="text/javascript" src="/js/jquery-ui/jquery.ui.core.min.js"></script>
    <script src="/Resources/admin/js/jquery-ui/jquery.ui.widget.min.js" type="text/javascript"></script>
    <script src="/Resources/admin/js/jquery-ui/jquery.ui.accordion.min.js" type="text/javascript"></script>
    <script src="/Resources/admin/js/jquery-ui/jquery.effects.core.min.js" type="text/javascript"></script>
    <script src="/Resources/admin/js/jquery-ui/jquery.effects.slide.min.js" type="text/javascript"></script>
    <script src="/Resources/admin/js/jquery-ui/jquery.ui.mouse.min.js" type="text/javascript"></script>
    <script src="/Resources/admin/js/jquery-ui/jquery.ui.sortable.min.js" type="text/javascript"></script>
    <script src="/Resources/admin/js/table/jquery.dataTables.min.js" type="text/javascript"></script>
    <!-- END: load jquery -->
    <script type="text/javascript" src="/Resources/admin/js/table/table.js"></script>
    <script src="/Resources/admin/js/setup.js" type="text/javascript"></script>
	 <script type="text/javascript">
        $(document).ready(function () {
            setupLeftMenu();
		    setSidebarHeight();
        });
    </script>

</head>
<body>
    <div class="container_12">
        <div class="grid_12 header-repeat">
            <div id="branding">
                <div class="floatleft logo">
                    <img src="../../../Resources/admin/img/livelogo.png" alt="Logo" />
				</div>
				<div class="floatleft middle">
					<h1>Manager Your Page</h1>
					<p>Never give up</p>
				</div>
                <div class="floatright">
                    <div class="floatleft">
                        <img src="/Resources/admin/img/img-profile.jpg" alt="Profile Pic" /></div>
                    <div class="floatleft marginleft10">
                        <ul class="inline-ul floatleft">
                            <li>Hello Admin</li>
                            <li><a href="#">Logout</a></li>
                        </ul>
                    </div>
                </div>
                <div class="clear">
                </div>
            </div>
        </div>
        <div class="clear">
        </div>
        <div class="grid_12">
            <ul class="nav main">
                <li class="ic-dashboard"><a href="adminManager"><span>Dashboard</span></a> </li>
                <li class="ic-form-style"><a href="profile"><span>User Profile</span></a></li>
				<li class="ic-typography"><a href="change-password"><span>Change Password</span></a></li>
				<li class="ic-grid-tables"><a href="inbox"><span>Inbox</span></a></li>
                <li class="ic-charts"><a href="chart.jsp"><span>Visit Website</span></a></li>
            </ul>
        </div>
        <div class="clear">
        </div>
    