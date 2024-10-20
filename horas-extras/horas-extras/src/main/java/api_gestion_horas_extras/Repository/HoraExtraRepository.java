package api_gestion_horas_extras.Repository;

import api_gestion_horas_extras.Model.HoraExtra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HoraExtraRepository extends JpaRepository<HoraExtra, Long> {
}
