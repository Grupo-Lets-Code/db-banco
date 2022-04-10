package br.com.letscode.dbbanco.entities;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
    public BigDecimal FormatValor (BigDecimal valor){
        return valor.setScale(2, RoundingMode.HALF_EVEN);
    }
}
