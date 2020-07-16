window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.Abastecimento = window.blockly.js.blockly.Abastecimento || {};

/**
 * Abastecimento
 */
window.blockly.js.blockly.Abastecimento.Filtrar = function() {
 var item, valid;
  this.cronapi.screen.refreshDatasource("Abastecimento", 'true');
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.Abastecimento.Confirmar = function() {
 var item, valid;
  if (this.blockly.js.blockly.Abastecimento.validar()) {
    this.cronapi.screen.post("Abastecimento");
  } else {
    this.cronapi.screen.notify('error','Dados inválidos !!');
  }
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.Abastecimento.validar = function() {
 var item, valid;
  if (this.cronapi.screen.getValueOfField("Abastecimento.active.valor") > 10000) {
    valid = false;
    this.cronapi.screen.notify('error','Valor acima do limite !!');
  } else {
    valid = true;
  }
  return valid;
}
