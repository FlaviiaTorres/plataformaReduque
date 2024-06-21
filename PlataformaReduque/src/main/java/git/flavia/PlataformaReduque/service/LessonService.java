package git.flavia.PlataformaReduque.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import git.flavia.PlataformaReduque.model.Lesson;
import git.flavia.PlataformaReduque.repository.LessonRepository;

@Service
public class LessonService {

    @Autowired
    private LessonRepository lessonRepository;

    public List<Lesson> getAllLessons() {
        return lessonRepository.findAll();
    }

    public Lesson getLessonById(Long id) {
        return lessonRepository.findById(id).orElse(null);
    }

    public Lesson createLesson(Lesson lesson) {
        return lessonRepository.save(lesson);
    }

    public Lesson updateLesson(Long id, Lesson updatedLesson) {
        return lessonRepository.findById(id)
            .map(lesson -> {
                lesson.setTitle(updatedLesson.getTitle());
                lesson.setVideoUrl(updatedLesson.getVideoUrl());
                return lessonRepository.save(lesson);
            })
            .orElse(null);
    }

    public void deleteLesson(Long id) {
        lessonRepository.deleteById(id);
    }
}
