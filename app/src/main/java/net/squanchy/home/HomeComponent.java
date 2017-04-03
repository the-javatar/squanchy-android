package net.squanchy.home;

import net.squanchy.analytics.Analytics;
import net.squanchy.injection.ActivityLifecycle;
import net.squanchy.injection.ApplicationComponent;
import net.squanchy.navigation.NavigationModule;
import net.squanchy.navigation.Navigator;
import net.squanchy.proximity.preconditions.ProximityOptInPersister;
import net.squanchy.proximity.preconditions.ProximityPreconditions;
import net.squanchy.proximity.preconditions.ProximityPreconditionsModule;
import net.squanchy.remoteconfig.RemoteConfig;
import net.squanchy.service.proximity.injection.ProximityService;
import net.squanchy.support.injection.CurrentTimeModule;

import dagger.Component;

@ActivityLifecycle
@Component(modules = {NavigationModule.class, CurrentEventModule.class, CurrentTimeModule.class, ProximityPreconditionsModule.class}, dependencies = ApplicationComponent.class)
interface HomeComponent {

    Analytics analytics();

    ProximityService proximityService();

    Navigator navigator();

    CurrentEventService currentEvent();

    RemoteConfig remoteConfig();

    ProximityPreconditions proximityPreconditions();

    ProximityOptInPersister proximityOptInPersister();
}
