package org.eternity.exam;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Component;
import org.eternity.exam.Lecture;
import org.eternity.exam.SerializedLecture;

@Component
public class XmlLectureFormatter implements LectureFormatter{

    private final XmlMapper xmlMapper;

    public XmlLectureFormatter() {
        this.xmlMapper = new XmlMapper();
        this.xmlMapper.registerModule(new JavaTimeModule());
    }

    @Override
    public String type() {
        return "xml";
    }

    @Override
    public SerializedLecture serialize(Lecture lecture) throws Exception {
        String content = xmlMapper.writeValueAsString(lecture);
        return new SerializedLecture(type(), content, "xml");
    }

}
