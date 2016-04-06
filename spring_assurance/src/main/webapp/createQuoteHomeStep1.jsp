<form:form action="/wizard.form?_page=2" method="post" modelAttribute="modelWizard">
    <form:label path="step1">Créer un devis habitation - Étape 1 : </form:label>
    <div><label>Nom du devis : <input type="text" name="quoteName"/></label></div>
    <div><label>Prénom : <input type="text" name="firstname"/></label></div>
    <div><label>Nom : <input type="text" name="name"/></label></div>
    <div><label>Type habitation : <input type="text" name="houseType"/></label></div>
    <div><label>Surface : <input type="text" name="surface"/></label></div>
    <form:input path="step1" />
    <input type="submit" value="Aller à l'étape 2" />
</form:form>