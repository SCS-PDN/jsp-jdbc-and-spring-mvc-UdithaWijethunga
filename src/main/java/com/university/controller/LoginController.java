@Controller
public class LoginController {
    @Autowired
    JdbcTemplate jdbc;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, HttpSession session, Model model) {
        try {
            String sql = "SELECT student_id, name FROM students WHERE email=? AND password=?";
            Map<String, Object> user = jdbc.queryForMap(sql, email, password);
            session.setAttribute("studentId", user.get("student_id"));
            session.setAttribute("studentName", user.get("name"));
            return "redirect:/courses";
        } catch (Exception e) {
            model.addAttribute("error", "Invalid email or password");
            return "login";
        }
    }
}
