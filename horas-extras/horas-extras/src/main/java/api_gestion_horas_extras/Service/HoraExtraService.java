package api_gestion_horas_extras.Service;

import api_gestion_horas_extras.Model.HoraExtra;
import api_gestion_horas_extras.Repository.HoraExtraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HoraExtraService {

    @Autowired
    private HoraExtraRepository repository;

    // Método para obtener todas las horas extras
    public List<HoraExtra> obtenerHorasExtras() {
        return repository.findAll();
    }

    // Método para registrar una lista de horas extras
    public List<HoraExtra> registrarHorasExtras(List<HoraExtra> horasExtras) {
        // Itera sobre cada HoraExtra en la lista para aplicar la lógica
        for (HoraExtra horaExtra : horasExtras) {
            double valorBase = horaExtra.getValorHora();
            switch (horaExtra.getTipo()) {
                case "Diurna":
                    horaExtra.setValorHora(valorBase * 1.25);
                    break;
                case "Nocturna":
                    horaExtra.setValorHora(valorBase * 1.75);
                    break;
                case "Festiva":
                case "Dominical":
                    horaExtra.setValorHora(valorBase * 2.0);
                    break;
            }
        }
        // Guarda todas las horas extras en la base de datos
        return repository.saveAll(horasExtras);
    }
}

