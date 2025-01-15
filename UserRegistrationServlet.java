@WebServlet("/register")
public class UserRegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // This is just a placeholder for the DAO
    private UserDao userDao;

    public UserRegistrationServlet() {
        super();
        userDao = new UserDao();
    }

    // Handle GET request to display registration form
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/register.jsp");
        dispatcher.forward(request, response);
    }

    // Handle POST request to process the form submission
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        // Create User object and save it to the database
        User user = new User(username, password, email);
        boolean isRegistered = userDao.registerUser(user);

        if (isRegistered) {
            response.sendRedirect("profile");
        } else {
            request.setAttribute("errorMessage", "Registration failed.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/register.jsp");
            dispatcher.forward(request, response);
        }
    }
}
