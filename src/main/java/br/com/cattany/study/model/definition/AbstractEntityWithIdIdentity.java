package br.com.cattany.study.model.definition;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * Representa uma entidade JPA, que possui um <code>ID</code>, cujo sua geração é realizado via <i>auto-incremento</i>,
 * usando a estratégia {@link GenerationType#IDENTITY}.
 *
 * <hr>
 *
 * <p>
 *      Especificações:
 * </p>
 *
 * <ul>
 *      <li>
 *          {@link MappedSuperclass} - Define que esta é uma entidade abstrata JPA, sendo necessária uma implementação.
 *      </li>
 *
 *      <li>
 *          {@link AllArgsConstructor} - Gera o construtor automaticamente, baseado nos campos da classe atual
 * (no caso desta classe, apenas o {@link #id}).
 *      </li>
 *      <li>
 *          {@link NoArgsConstructor} - Gera o construtor default automaticamente, no caso quando a classe já possui um construtor.
 *      </li>
 *      <li>
 *          {@link Data} - Gera equals e hashcode, getters and setters, toString e RequiredArgsConstructor automaticamente, baseado nos campos da classe atual
 * (no caso desta classe, apenas o {@link #id}).
 *      </li>
 * </ul>
 *
 * <hr>
 *
 * <p>
 *     Veja na classe de Teste desta classe, o exemplo de como pode ser usado uma classe concreta.
 * </p>
 *
 * @author Bruno Cattany
 * @see <a href="https://projectlombok.org/">Project Lombok</a>
 * @see <a href="https://medium.com/collabcode/projeto-lombok-escrevendo-menos-c%C3%B3digo-em-java-8fc87b379209">Lombok - Escrevendo menos</a>
 * @see <a href="https://projectlombok.org/setup/eclipse">Lombok Plugin - Eclipse</a>
 * @see <a href="https://projectlombok.org/setup/intellij">Lombok Plugin - IntelliJ IDEA</a>
 * @since 20/06/2018
 */
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public abstract class AbstractEntityWithIdIdentity implements Serializable {

  /**
   * Especificações:
   * <ul>
   *     <li>{@link Id} - Define que será o <b>identificador da entidade</b> e consequentemente,
   *     terá no banco de dados, o nome da coluna sendo: <b>id</b>.</li>
   *     <li>{@link GeneratedValue} - Define que a estratégia de incremento, será através de <b>auto-incremento</b>,
   *     definido pelo <i>Banco de Dados em questão</i>.</li>
   *     <li>{@link Getter} and {@link Setter} - Gera os métodos <b>get e set</b> automaticamente.</li>
   * </ul>
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
}
