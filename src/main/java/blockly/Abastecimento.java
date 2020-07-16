package blockly;

import cronapi.*;
import cronapi.rest.security.CronappAudit;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;



@CronappAudit
@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Abastecimento {

public static final int TIMEOUT = 300;

/**
 *
 * @param Entidade
 * @return Var
 */
// Abastecimento
public static Var custoKm(Var Entidade) throws Exception {
 return new Callable<Var>() {

   private Var custo = Var.VAR_NULL;

   public Var call() throws Exception {
    custo = Var.valueOf(0);
    if (cronapi.logic.Operations.isNullOrEmpty(cronapi.object.Operations.getObjectField(Entidade, Var.valueOf("km"))).negate().getObjectAsBoolean()) {
        if (Var.valueOf(!cronapi.object.Operations.getObjectField(Entidade, Var.valueOf("km")).equals(Var.valueOf(0))).getObjectAsBoolean()) {
            custo = cronapi.math.Operations.divisor(cronapi.object.Operations.getObjectField(Entidade, Var.valueOf("valor")),cronapi.object.Operations.getObjectField(Entidade, Var.valueOf("km")));
        }
    }
    return custo;
   }
 }.call();
}

/**
 *
 * @param Entidade
 * @return Var
 */
// Abastecimento
public static Var kmPorLitro(Var Entidade) throws Exception {
 return new Callable<Var>() {

   private Var litros = Var.VAR_NULL;
   private Var kmPorLitro = Var.VAR_NULL;

   public Var call() throws Exception {
    litros = Var.valueOf(0);
    if (cronapi.logic.Operations.isNullOrEmpty(cronapi.object.Operations.getObjectField(Entidade, Var.valueOf("precoLitro"))).negate().getObjectAsBoolean()) {
        if (Var.valueOf(!cronapi.object.Operations.getObjectField(Entidade, Var.valueOf("precoLitro")).equals(Var.valueOf(0))).getObjectAsBoolean()) {
            litros = cronapi.math.Operations.divisor(cronapi.object.Operations.getObjectField(Entidade, Var.valueOf("valor")),cronapi.object.Operations.getObjectField(Entidade, Var.valueOf("precoLitro")));
        }
    }
    if (Var.valueOf(!litros.equals(Var.valueOf(0))).getObjectAsBoolean()) {
        kmPorLitro = cronapi.math.Operations.divisor(cronapi.object.Operations.getObjectField(Entidade, Var.valueOf("km")),litros);
    } else {
        kmPorLitro = Var.valueOf(0);
    }
    return kmPorLitro;
   }
 }.call();
}

}

