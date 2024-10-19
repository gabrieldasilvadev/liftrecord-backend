//package br.com.liftrecord.api.controllers.student;
//
//import br.com.liftrecord.api.controllers.student.mappers.RegisterStudentControllerMapper;
//import br.com.liftrecord.shared.mediator.Mediator;
//import org.springframework.stereotype.Controller;
//
//@Controller
//public class StudentController {
//
//  private final Mediator mediator;
//
//  public StudentController(Mediator mediator) {
//    this.mediator = mediator;
//  }
//
//  @Override
//  public HttpResponse<@Valid RegisterStudentResponse> postStudents(RegisterStudentRequest registerStudentRequest) {
//    RegisterStudentControllerMapper mapper = RegisterStudentControllerMapper.INSTANCE;
//    return HttpResponse.created(mapper.toResponse(mediator.execute(mapper.toCommand(registerStudentRequest))));
//  }
//}
