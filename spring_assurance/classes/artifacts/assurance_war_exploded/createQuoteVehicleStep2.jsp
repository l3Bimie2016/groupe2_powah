<form:form action="/wizard.form?_page=3" method="post" modelAttribute="modelWizard">
    <form:label path="step2">Créer un devis véhicule - Étape 2 : </form:label>
    <div><label>Date du permis : <input type="text" name="licenseDate"/></label></div>
    <div><label>Nombre d'accidents : <input type="text" name="nbAccident"/></label></div>
    <div><label>Bonus - malus : <input type="text" name="bolusMalus"/></label></div>
    <form:input path="step2" />
    <input type="submit" value="Aller à l'étape 3" />
</form:form>