<form:form action="/wizard.form?_page=4" method="post" modelAttribute="modelWizard">
    <form:label path="step3">Créer un devis véhicule - Étape 3 : </form:label>
    <div><label>Conducteur principal : <input type="text" name="firstDriver"/></label></div>
    <div><label>Conducteur secondaire : <input type="text" name="secondDriver"/></label></div>
    <div><label>Garage : <input type="radio" value="yes"/>Oui<input type="radio" value="no"/>Non</label></div>
    <div><label>Adresse stationnement : <input type="text" name="garageAdress"/></label></div>
    <form:input path="step3" />
    <input type="submit" value="Aller à l'étape 4" />
</form:form>