package br.com.liftrecord;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RemoveStudentBaseComponentTest extends BaseComponentTest {

  @Test
  @DisplayName("Given a valid request, When DELETE /students/{id}, Then return status 204 (No Content) Student removed")
  void testRemoveStudentStatusNoContent() {
  }
}
