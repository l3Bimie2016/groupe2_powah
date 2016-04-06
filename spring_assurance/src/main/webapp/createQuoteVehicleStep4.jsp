<form:form action="/wizard.form?_finish=1" method="post" modelAttribute="modelWizard">
    <form:label path="step4">Créer un devis véhicule - Étape 4 : </form:label>
    <div>Résumé : </div>
    <div><label>Protection : <input type="radio" value="1"/>Tous risques<input type="radio" value="2"/>Au tiers</label></div>
    <div>Prix : </div>
    <form:input path="step4" />
    <input type="submit" value="Finaliser" />
</form:form>