@Controller
public class CourseController {
    @Autowired
    JdbcTemplate jdbc;

    @GetMapping("/courses")
    public String listCourses(Model model) {
        model.addAttribute("courses", jdbc.queryForList("SELECT * FROM courses"));
        return "courses";
    }

    @PostMapping("/register/{courseId}")
    public String register(@PathVariable int courseId, HttpSession session, Model model) {
        int studentId = (int) session.getAttribute("studentId");
        String check = "SELECT COUNT(*) FROM registrations WHERE student_id=? AND course_id=?";
        int exists = jdbc.queryForObject(check, Integer.class, studentId, courseId);

        if (exists == 0) {
            jdbc.update("INSERT INTO registrations (student_id, course_id, date) VALUES (?, ?, NOW())", studentId, courseId);
            model.addAttribute("message", "Successfully registered!");
        } else {
            model.addAttribute("message", "Already registered for this course!");
        }
        return "success";
    }
}


