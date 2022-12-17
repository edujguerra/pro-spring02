package com.edujguerra.spring.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.edujguerra.spring.model.Movimentacao;

public interface MovimentacaoRepo extends JpaRepository<Movimentacao, Long> {

}
