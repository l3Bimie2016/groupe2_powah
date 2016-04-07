<form:form action="/wizard.form?_page=2" method="post" modelAttribute="modelWizard">
    <form:label path="step1">Créer un devis véhicule - Étape 1 : </form:label>
        <div><label>Nom du devis : <input type="text" name="quoteName"/></label></div>
        <div><label>Prénom : <input type="text" name="firstname"/></label></div>
        <div><label>Nom : <input type="text" name="name"/></label></div>
        <div><label>Marque : <input type="text" name="brand"/></label></div>
        <div><label>Modèle : <input type="text" name="model"/></label></div>
        <div><label>Carburant : <input type="text" name="typeFuel"/></label></div>
        <div><label>Cheveaux fiscaux : <input type="text" name="fiscalHorsePower"/></label></div>
    <form:input path="step1" />
    <input type="submit" value="Aller à l'étape 2" />
</form:form>