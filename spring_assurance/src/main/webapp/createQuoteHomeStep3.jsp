<form:form action="/wizard.form?_page=4" method="post" modelAttribute="modelWizard">
    <form:label path="step3">Créer un devis habitation - Étape 3 : </form:label>
    <div><label>Surface du jardin : <input type="text" name="gardenArea"/></label></div>
    <div><label>Surface de la terrasse : <input type="text" name="terraceArea"/></label></div>
    <div><label>Type de chauffage : <input type="text" name="heatingType"/></label></div>
    <form:input path="step3" />
    <input type="submit" value="Aller à l'étape 4" />
</form:form>