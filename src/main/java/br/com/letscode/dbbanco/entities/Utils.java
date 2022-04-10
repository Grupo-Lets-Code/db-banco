package br.com.letscode.dbbanco.entities;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class Utils {

    public LocalDate formatarData(String data) {
        String[] fields = data.split("/");
        return LocalDate.of(
                Integer.parseInt(fields[2]),
                Integer.parseInt(fields[1]),
                Integer.parseInt(fields[0])
        );

    }
}
